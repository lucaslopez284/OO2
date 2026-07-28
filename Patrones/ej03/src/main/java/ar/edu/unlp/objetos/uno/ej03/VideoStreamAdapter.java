package ar.edu.unlp.objetos.uno.ej03;

public class VideoStreamAdapter extends Media {

	private VideoStream videoStream;

	public VideoStream(VideoStream videoStream) {
		this.videoStream = videoStream;
	}
		
	public void play() {
		this.videoStream.reproduce();
	}

}
