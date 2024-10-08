package main;

import config.ProjectConfig;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
//        CommentRepository commentRepository = new DBCommentRepository();
//        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();
//
//        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Laura");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
    }
}
