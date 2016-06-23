package io.github.howiefh.console;

import com.esotericsoftware.reflectasm.MethodAccess;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * jdk reflection time: 369
 * fast get time: 257
 * pure get time: 106
 * reflectasm index time: 221
 * reflectasm time: 589
 *
 * @author fenghao on 2016/5/23
 * @version 1.0
 * @since 1.0
 */
public class ReflectDemo {
    private Method getName;
    private Method getId;
    private Method getFriends;

    private FastMethod fastGetName;
    private FastMethod fastGetId;
    private FastMethod fastGetFriends;

    private MethodAccess access;
    private int indexName;
    private int indexId;
    private int indexFriends;

    private int count = 10000000;
    private Object[] dontCompileMeAway = new Object[3 * count];
    private Object[] args = new Object[0];

    public static void main(String[] args) {
        try {
            ReflectDemo demo = new ReflectDemo();
            demo.init();
            demo.testReflect();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void init() throws NoSuchMethodException {
        Class clazz = Person.class;
        access = MethodAccess.get(Person.class);
        indexName = access.getIndex("getName");
        indexId = access.getIndex("getId");
        indexFriends = access.getIndex("getFriends");

        getName = getMethod(clazz, "getName");
        getId = getMethod(clazz, "getId");
        getFriends = getMethod(clazz, "getFriends");

        fastGetName = getFastMethod(clazz, "getName");
        fastGetId = getFastMethod(clazz, "getId");
        fastGetFriends = getFastMethod(clazz, "getFriends");
    }

    private FastMethod getFastMethod(Class cla, String method) {
        FastClass clazz = FastClass.create(cla);
        return clazz.getMethod(method, null);
    }

    private Method getMethod(Class clazz, String m) throws NoSuchMethodException {
        return clazz.getMethod(m, null);
    }

    public void testReflect() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Person person = new Person(1, "howie", new ArrayList<Person>());
        for (int i = 0; i < 100; i++) {
            System.err.println(i);
            test(person);
        }
    }

    private void test(Person person) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dontCompileMeAway[i + 0] = getName.invoke(person, args);
            dontCompileMeAway[i + 1] = getId.invoke(person, args);
            dontCompileMeAway[i + 2] = getFriends.invoke(person, args);

        }
        long end = System.currentTimeMillis();
        System.err.println("jdk reflection time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dontCompileMeAway[i + 0] = fastGetName.invoke(person, args);
            dontCompileMeAway[i + 1] = fastGetId.invoke(person, args);
            dontCompileMeAway[i + 2] = fastGetFriends.invoke(person, args);
        }
        end = System.currentTimeMillis();
        System.err.println("fast get time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dontCompileMeAway[i + 0] = person.getName();
            dontCompileMeAway[i + 1] = person.getId();
            dontCompileMeAway[i + 2] = person.getFriends();
        }
        end = System.currentTimeMillis();
        System.err.println("pure get time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dontCompileMeAway[i + 0] = access.invoke(person, indexName, args);
            dontCompileMeAway[i + 1] = access.invoke(person, indexId, args);
            dontCompileMeAway[i + 2] = access.invoke(person, indexFriends, args);
        }
        end = System.currentTimeMillis();
        System.err.println("reflectasm index time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            dontCompileMeAway[i + 0] = access.invoke(person, "getName");
            dontCompileMeAway[i + 1] = access.invoke(person, "getId");
            dontCompileMeAway[i + 2] = access.invoke(person, "getFriends");
        }
        end = System.currentTimeMillis();
        System.err.println("reflectasm time: " + (end - start));
    }
}
