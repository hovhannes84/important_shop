package com.example.important_shop.controller;

import com.example.important_shop.entity.*;
import com.example.important_shop.repository.CartProductRepository;
import com.example.important_shop.security.CurrentUser;
import com.example.important_shop.service.CartService;
import com.example.important_shop.service.CategoryService;
import com.example.important_shop.service.OrdersService;
import com.example.important_shop.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@Controller
//@RequestMapping("/cart")
//@RequiredArgsConstructor
//public class CartController {
//
//
//    private final CategoryService categoryService;
//    private final CartService cartService;

    @Controller
    @RequestMapping("/cart")
    public class CartController {

        private final CartService cartService;
        private final ProductService productService;
        private final CartProductRepository cartProductRepository;
        private final OrdersService ordersService;
        private final CategoryService categoryService;


        public CartController(CartService cartService, ProductService productService, CartProductRepository cartProductRepository, OrdersService ordersService, CategoryService categoryService) {
            this.cartService = cartService;
            this.productService = productService;
            this.cartProductRepository = cartProductRepository;
            this.ordersService = ordersService;

            this.categoryService = categoryService;
        }
        @PostMapping("/add")
        public String addToCart(@RequestParam("productId") int productId, @AuthenticationPrincipal CurrentUser currentUser) {
            Optional<Product> product = productService.findById(productId);

            if (product.isPresent()) {
                List<Cart> carts = cartService.findCartsByUser(currentUser.getUser());

                if (!carts.isEmpty()) {
                    Cart cart = carts.get(0);
                    CartProduct cartProduct = new CartProduct();
                    cartProduct.setCart(cart);
                    cartProduct.setProduct(product.get());
                    cartProductRepository.save(cartProduct);
                    cartService.addCart(currentUser.getUser());
                }
            }

            return "redirect:/products";
        }
        @PostMapping("/{id}")
        public String singleCartPage(@PathVariable("id") int id, ModelMap modelMap) {
            Optional<CartProduct> byId = cartProductRepository.findById(id);
            if (byId.isPresent()) {
                CartProduct cartProduct = byId.get();
                List<CartProduct> products = cartProductRepository.findAll();
                modelMap.addAttribute("cartProduct", cartProduct);
                modelMap.addAttribute("products", products);
                return "singleCart";
            } else {
                return "redirect:/products";
            }
        }

        @PostMapping("/order/add/{id}")
        public String singleOrder(@PathVariable("id") int id, ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
            Optional<Product> byId = productService.findById(id);
            if (byId.isPresent()) {
                Product product = byId.get();
                Optional<CartProduct> cartProduct = cartProductRepository.findFirstByProduct(product);
                if (cartProduct.isPresent()) {
                    Orders orders = new Orders();
                    orders.setDateTime(new Date());
                    ordersService.addOrders(orders, currentUser.getUser());
                    cartProductRepository.deleteById(cartProduct.get().getId());
                }
            }
            return "redirect:/products";
        }
        @GetMapping("/admin")
        public String adminPage(ModelMap modelMap) {
            List<Product> products = productService.findProducts();
            List<Category> categories = categoryService.findCategories();
            modelMap.addAttribute("categories", categories);
            modelMap.addAttribute("products", products);
            return "admin";
        }



    }
