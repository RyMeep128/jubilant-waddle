package application;

import application.objects.MoveableObject;

public class MoveRequest {
    public final MoveableObject obj;
    public final Direction dir;

    public MoveRequest(MoveableObject obj, Direction dir) {
        this.obj = obj;
        this.dir = dir;
    }
}
