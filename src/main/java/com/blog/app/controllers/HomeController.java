package com.blog.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.models.Post;
import com.blog.app.repositories.UserRepository;
import com.blog.app.services.NotificationService;
import com.blog.app.services.PostService;

import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/data")
    public String home(Model model) {
    	System.out.println("this is home controller data");
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);

        List<Post> latest3Posts = latest5Posts.stream() .limit(3).collect(toList());
               
        model.addAttribute("latest3posts", latest3Posts);

        return "index";
    }

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
                      
        Post post = postService.findById(id);

        if (post == null) {
            notificationService.addErrorMessage( "Cannot find post: " + id);
                   
            return "redirect:/data";
        }

        model.addAttribute("post", post);
        return "/posts/index";
    }

}