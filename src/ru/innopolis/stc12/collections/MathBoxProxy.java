package ru.innopolis.stc12.collections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MathBoxProxy implements InvocationHandler {
    private MathBox mathBox;    //TODO this is right if use two or more interfaces?

    public MathBoxProxy(MathBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getAnnotation(ClearData.class) != null) {
            Field field = mathBox.getClass().getDeclaredField("list");
            field.setAccessible(true);
            List list = (List) field.get(mathBox);
            list.clear();
            //field.set(mathBox, new ArrayList<>());
        }

        if (mathBox.getClass().getAnnotation(Logged.class) != null) {
            long startTime = System.currentTimeMillis();
            System.out.print("We call method " + method.getName());
            Object object = method.invoke(mathBox, args);
            System.out.println(" with time " + (System.currentTimeMillis() - startTime));
            return object;
        } else {
            return method.invoke(mathBox, args);
        }
    }
}
