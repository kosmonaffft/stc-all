package university.innopolis.stc.reflection.methods;

import university.innopolis.stc.reflection.annotation.RunMe;

public class MethodsToRun {

    @RunMe
    @Deprecated
    public String m1() {
        return "Hello, world 1";
    }

    @Deprecated
    public String m2() {
        return "Hello, world 2";
    }

    @RunMe
    @Deprecated
    public String m3() {
        return "Hello, world 3";
    }

    public String m4() {
        return "Hello, world 4";
    }

    @RunMe
    public String m5() {
        return "Hello, world 5";
    }
}
