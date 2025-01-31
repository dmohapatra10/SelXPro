package utils;

import utils.group_annotations.Bug;
import utils.group_annotations.Regression;
import utils.group_annotations.Smoke;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CustomAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            if (testMethod.isAnnotationPresent(Smoke.class)) {
                annotation.setGroups(new String[]{"smoke"});
            } else if (testMethod.isAnnotationPresent(Regression.class)) {
                annotation.setGroups(new String[]{"regression"});
            } else if (testMethod.isAnnotationPresent(Bug.class)) {
                annotation.setGroups(new String[]{"bug"});
            }
        }
    }
}
