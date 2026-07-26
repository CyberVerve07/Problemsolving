package oops.Multiple;

/**
 * MusicPlayer — Interface for music playback functionality.
 *
 * INTERVIEW: Why separate interfaces for Camera and MusicPlayer?
 * → Each interface represents a SPECIFIC capability/behavior.
 * → A SmartPhone can have BOTH capabilities (Camera + MusicPlayer).
 * → This follows the INTERFACE SEGREGATION PRINCIPLE (ISP):
 *   "Clients should not be forced to depend on interfaces they don't use."
 * → A simple phone might only implement MusicPlayer, not Camera.
 *
 * JAVA TYPE: interface
 *
 * @author Aditya
 * @version 2.0
 * @see Smartphone
 * @see Camera
 */
interface MusicPlayer {

    /**
     * Plays music — implementing class provides the actual logic.
     */
    void playMusic();
}
