package oops.multiple;

/**
 * MusicPlayer â€” Interface for music playback functionality.
 *
 * INTERVIEW: Why separate interfaces for Camera and MusicPlayer?
 * â†’ Each interface represents a SPECIFIC capability/behavior.
 * â†’ A SmartPhone can have BOTH capabilities (Camera + MusicPlayer).
 * â†’ This follows the INTERFACE SEGREGATION PRINCIPLE (ISP):
 *   "Clients should not be forced to depend on interfaces they don't use."
 * â†’ A simple phone might only implement MusicPlayer, not Camera.
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
     * Plays music â€” implementing class provides the actual logic.
     */
    void playMusic();
}
