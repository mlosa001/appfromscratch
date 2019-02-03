//package android.example.com.myapplication.network;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class AndroidRetro {
//    private static Retrofit ourInstance;
//
//
//        //need tis method cux its an instance
//
//        private AndroidRetro() {
//        }
//
//        public static Retrofit getInstance() {
//            if (ourInstance != null) {
//                return ourInstance;
//            }
//
//            //builder method
//
//            ourInstance = new Retrofit
//                    .Builder()
//                    .baseUrl("https://api.learn2crack.com")
//                    .addConverterFactory(GsonConverterFactory.create())//parsing
//                    .build();
//            return ourInstance;
//        }
////Create a Singleton class using the Static Factory Method design pattern, to contain a unique single instance of the Retrofit class.
//
//
//    }
////y retrofit singleton ? why do we need an instance