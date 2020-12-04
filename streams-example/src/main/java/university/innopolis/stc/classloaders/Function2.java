package university.innopolis.stc.classloaders;

@FunctionalInterface
public interface Function2<R, T1, T2> {

    R apply(T1 arg1, T2 arg2);
}
