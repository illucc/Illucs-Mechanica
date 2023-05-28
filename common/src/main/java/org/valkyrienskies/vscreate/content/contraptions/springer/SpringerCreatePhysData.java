package org.valkyrienskies.vscreate.content.contraptions.springer;

import org.joml.Vector3dc;
import org.joml.Vector3ic;

import java.util.List;

public record SpringerCreatePhysData(Vector3dc springerPos, Vector3dc springerAxis, double springerAngle,
                                     double springerSpeed, List<Vector3ic> springerPositions, boolean inverted) {

}