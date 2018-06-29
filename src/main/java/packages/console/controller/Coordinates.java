package packages.console.controller;


public class Coordinates {
	private int x, y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void advance(String direction) {
		if (direction == "north")
			y -= 1;
		else if (direction == "east")
			x += 1;
		else if (direction == "south")
			y += 1;
		else if (direction == "west")
			x -= 1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean Isequals(Coordinates other) {
		return (this.y == other.y && this.x == other.x);
	}
}