# Aturan Proguard/R8 khusus project ini.
# Filament & gltfio pakai reflection di beberapa bagian -- tambahkan
# keep rules di sini kalau nanti ada crash "ClassNotFoundException"
# saat build release dengan minifyEnabled = true.

-keep class com.google.android.filament.** { *; }
-keep class com.google.android.filament.gltfio.** { *; }
-keep class com.google.android.filament.utils.** { *; }

# kotlinx.serialization butuh keep rules untuk data class yang di-serialize
-keepattributes *Annotation*, InnerClasses
-keep class com.renderinterior.app.data.model.** { *; }
-keep class com.renderinterior.app.data.api.** { *; }
