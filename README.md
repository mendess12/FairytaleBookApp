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
- Bağımlılık yönetimi için Dagger - Hilt
- Veri aktarımı için Parcelable kullandım.
<hr>

### 3. Parti kütüphaneler
<pre>
- build.gradle(:app)
  
  - Plugin 
      id 'com.google.gms.google-services'
      id 'androidx.navigation.safeargs.kotlin'
      id 'dagger.hilt.android.plugin'
      id 'kotlin-kapt'
      id 'kotlin-parcelize'
  
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
- [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [RecyclerView](https://www.tutorialkart.com/kotlin-android/kotlin-android-recyclerview/#gsc.tab=0)
- [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
- [Parcelable](https://developer.android.com/kotlin/parcelize)
- [Picasso](https://square.github.io/picasso/)
- [Fragment & Fragment View lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
- [ViewModel and ViewModel lifecycle](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [ViewModel Scope](https://developermemos.com/posts/viewmodel-scope-android)
- [ViewModel Scoping APIs](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)
- [Learn Jetpack Navigation - Codelab](https://developer.android.com/codelabs/android-navigation#0)

  ### UI Tasarımları
  
![liste](https://github.com/mendess12/FairytaleBookApp/assets/76566952/fba7f75f-11fc-450a-b3af-b7b97f847d4a) ![arama](https://github.com/mendess12/FairytaleBookApp/assets/76566952/8075f6d4-5201-4b2f-a1f9-af40776570c1)
 ![detail](https://github.com/mendess12/MasalKitabim/assets/76566952/8f13d3c7-76c9-4fea-ac2a-2bd45445e0a2)


