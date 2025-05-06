module game {
	exports application;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires transitive java.desktop;
	requires javafx.media;
	opens application to javafx.graphics;
}
