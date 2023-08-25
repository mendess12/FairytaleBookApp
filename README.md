# FairytaleBookApp

### Projenin Amacı
<pre>Ebeveynlerin, bebeklerine ve küçük yaştaki çocuklarına uyumak ve kaliteli vakit geçirmek için okuayacabilecekleri <br>yaklaşık 50 tane masalın olduğu bir uygulamadır.</pre>
<hr>

### Kullanılan Teknolojiler
- Görseller için Firebase Storage,
- Masallar için Firebase Firestore,
- İmage yüklemek için Picasso,
- Tasrım widget'larına erişmek için ViewBinding,
- Veri akışını yönetmek için LiveData, arayüz durumunun yönetimi için UIState,
- Fragmentlar arası geçiş ve veri göndermek için Jetpack Navigation component,
- Model olarakta MVVM
- Asenkron işlemler için Coroutine
- Bağımlılık yönetimi için Dagger - Hilt kullandım.
<hr>

### 3. Parti kütüphaneler
<pre>
- build.gradle(:app)
  
  - Plugin 
      id 'com.google.gms.google-services'
      id 'androidx.navigation.safeargs.kotlin'
      id 'dagger.hilt.android.plugin'
      id 'kotlin-kapt'
  
  - Dependencies
  
    def nav_version = "2.6.0"
  
    //firebase bom
    implementation platform('com.google.firebase:firebase-bom:32.0.0')

    //firebase analytics
    implementation 'com.google.firebase:firebase-analytics-ktx'

    //firebase firestore
    implementation 'com.google.firebase:firebase-firestore-ktx'
  
    //mvvm
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
  
    //navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4'

    //dagger - hilt
    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"

    //picasso
    implementation 'com.squareup.picasso:picasso:2.71828'

    //view pager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    
- build.gradle(:project)

   - Dependencies
  
      def nav_version = "2.6.0"
      classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
      classpath 'com.google.gms:google-services:4.3.15'
      classpath 'com.google.dagger:hilt-android-gradle-plugin:2.44'

    - plugin
      id 'com.google.gms.google-services' version "4.3.15" apply false
</pre>
<hr>

### Kaynaklar
- [Firebase Firestore](https://firebase.google.com/docs/firestore/query-data/get-data?authuser=1)
- [Firebase Storage](https://firebase.google.com/docs/storage/android/start?authuser=1)
- [ViewPager2](https://tutorialwing.com/android-viewpager2-using-kotlin-with-example/)
- [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Dgger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
- [Picasso](https://square.github.io/picasso/)
- [Fragment & Fragment View lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
- [ViewModel and ViewModel lifecycle](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [ViewModel Scope](https://developermemos.com/posts/viewmodel-scope-android)
- [ViewModel Scoping APIs](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)
- [Learn Jetpack Navigation - Codelab](https://developer.android.com/codelabs/android-navigation#0)

  ### UI Tasarımları

  ![list](https://github.com/mendess12/MasalKitabim/assets/76566952/2f161828-bbf5-4b1c-a538-0961a5189a55)  ![detail](https://github.com/mendess12/MasalKitabim/assets/76566952/8f13d3c7-76c9-4fea-ac2a-2bd45445e0a2)

  [untitled.webm](https://github.com/mendess12/MasalKitabim/assets/76566952/fd895d81-ee69-445f-be38-83b3d01c2d93)
