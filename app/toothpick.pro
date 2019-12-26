-dontwarn javax.inject.**
-dontwarn javax.annotation.**
-keep class javax.inject.**
-keep class javax.annotation.**
-keepclassmembers class * {
    @javax.inject.Inject <init>(...);
    @javax.inject.Inject <init>();
    @javax.inject.Inject <fields>;
    public <init>(...);
}
-keepnames @toothpick.InjectConstructor class *
-keepclasseswithmembernames class * { toothpick.ktp.delegate.* *; }
-keepclassmembers class * {
    toothpick.ktp.delegate.* *;
}