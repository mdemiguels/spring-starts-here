package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service1 = context.getBean(CommentService.class);
        var service2 = context.getBean(UserService.class);

        System.out.println(service1.getCommentRepository() == service2.getCommentRepository());
    }
}
