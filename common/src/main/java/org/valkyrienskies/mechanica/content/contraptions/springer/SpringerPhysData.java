package org.valkyrienskies.mechanica.content.contraptions.springer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.joml.Vector3dc;
import org.joml.Vector3ic;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SpringerPhysData {
    public final Vector3dc springerPos;
    public final Vector3dc springerAxis;
    public final List<Vector3ic> springerPositions;
    public double springerAngle;
    public double springerSpeed;
    public boolean inverted;
    public Vector3dc prevAngularMomentum;

    // Default constructor for Jackson, should never be invoked manually
    @Deprecated
    public SpringerPhysData() {
        this.springerPos = null;
        this.springerAxis = null;
        this.springerPositions = null;
    }

    public SpringerPhysData(Vector3dc springerPos, Vector3dc springerAxis, double springerAngle, double springerSpeed, List<Vector3ic> springerPositions, boolean inverted) {
        this.springerPos = springerPos;
        this.springerAxis = springerAxis;
        this.springerAngle = springerAngle;
        this.springerSpeed = springerSpeed;
        this.springerPositions = springerPositions;
        this.inverted = inverted;
    }

    public void setPrevAngularMomentum(Vector3dc prevAngularMomentum) {
        this.prevAngularMomentum = prevAngularMomentum;
    }
    public Vector3dc getPrevAngularMomentum() {
        return prevAngularMomentum;
    }
}
