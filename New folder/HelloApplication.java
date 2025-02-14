package com.example.shapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.Group;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

//        Circle circle = new Circle(75.0f, 65.0f, 40.0f);
//        circle.setFill(Color.BLANCHEDALMOND);
//        circle.setStrokeWidth(5);
//        circle.setStroke(Color.GAINSBORO);
//          //x-axis pos, y-axis pos, length, height
//        Rectangle rect = new Rectangle(150, 30, 100, 65);
//        rect.setFill(Color.MEDIUMPURPLE);
//        rect.setStrokeWidth(6);
//        rect.setStroke(Color.YELLOWGREEN);
//          //x-axis pos, y-axis pos, length, height
//        Ellipse ell = new Ellipse(330, 60,60,35);
//        ell.setFill(Color.BLACK);
//        ell.setStrokeWidth(8);
//        ell.setStroke(Color.BISQUE);
//
//        Polygon poly = new Polygon(410, 60, 430, 90, 470, 30, 490, 60, 470, 100, 430, 100);
//        poly.setFill(Color.HONEYDEW); //coords of points
//        poly.setStrokeWidth(2);
//        poly.setStroke(Color.NAVY);
//
//        PhongMaterial newMat = new PhongMaterial();
//        newMat.setDiffuseColor(Color.LIGHTSTEELBLUE);
//        balletjie.setMaterial(newMat);
//
//        Group root = new Group(circle,rect,ell,poly);

        ///////////////////////////////////3D///////////////////////////////////////
        Sphere sphere1 = new Sphere();
        sphere1.setRadius(50.0);
        sphere1.setTranslateX(100); //x-axis position
        sphere1.setTranslateY(150); //y-axis position
        sphere1.setCullFace(CullFace.FRONT);

        Sphere sphere2 = new Sphere();
        sphere2.setRadius(50.0);
        sphere2.setTranslateX(300);
        sphere2.setTranslateY(150);
        sphere2.setCullFace(CullFace.BACK);

        Sphere sphere3 = new Sphere();
        sphere3.setRadius(50.0);
        sphere3.setTranslateX(500);
        sphere3.setTranslateY(150);
        sphere3.setCullFace(CullFace.NONE);

        Group root = new Group(sphere1, sphere2, sphere3);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Shapes and Colors");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}