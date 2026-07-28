//package oops.Multiple;
//// HEAD
//
///**
// * Smartphone — Implements MULTIPLE interfaces (Camera + MusicPlayer).
// *
// * INTERVIEW: How does Multiple Inheritance work in Java?
// * → Java supports Multiple Inheritance ONLY through INTERFACES.
// * → Smartphone implements Camera AND MusicPlayer.
// * → It MUST provide body for ALL abstract methods from BOTH interfaces:
// *   - click() from Camera
// *   - playMusic() from MusicPlayer
// *
// * INTERVIEW: What if both interfaces have the same default method?
// * → The implementing class MUST override the method to resolve the conflict.
// * → Otherwise, the compiler gives an error (ambiguity).
// *
// * NOTE: Added 'public' modifier — class name should match filename convention.
// *
// * JAVA TYPE: class implementing multiple interfaces
// * OOP PILLAR: Abstraction (Multiple Inheritance via Interfaces)
// *
// * @author Aditya
// * @version 2.0
// * @see Camera
// * @see MusicPlayer
// */
//class Smartphone implements Camera, MusicPlayer {
//
//=======
//
///**
// * Smartphone — Implements MULTIPLE interfaces (Camera + MusicPlayer).
// *
// * INTERVIEW: How does Multiple Inheritance work in Java?
// * → Java supports Multiple Inheritance ONLY through INTERFACES.
// * → Smartphone implements Camera AND MusicPlayer.
// * → It MUST provide body for ALL abstract methods from BOTH interfaces:
// *   - click() from Camera
// *   - playMusic() from MusicPlayer
// *
// * INTERVIEW: What if both interfaces have the same default method?
// * → The implementing class MUST override the method to resolve the conflict.
// * → Otherwise, the compiler gives an error (ambiguity).
// *
// * NOTE: Added 'public' modifier — class name should match filename convention.
// *
// * JAVA TYPE: class implementing multiple interfaces
// * OOP PILLAR: Abstraction (Multiple Inheritance via Interfaces)
// *
// * @author Aditya
// * @version 2.0
// * @see Camera
// * @see MusicPlayer
// */
//public class Smartphone implements Camera, MusicPlayfe85f421d2cb682cb4100dcce38957fd3f187bcd
//    /**
//     * Implementation of Camera's click() — captures a photo.
//     */
//    @Override
//    public void click() {
//        System.out.println("Photo Clicked");
//    }
//
//    /**
//     * Implementation of MusicPlayer's playMusic() — plays music.
//     */
//    @Override
//    public void playMusic() {
//        System.out.println("Playing Music");
//    }
//}
