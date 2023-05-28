package org.valkyrienskies.vscreate.content.forces

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnore
import net.minecraft.core.BlockPos
import org.joml.*
import org.valkyrienskies.core.api.ships.PhysShip
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.getAttachment
import org.valkyrienskies.core.api.ships.saveAttachment
import org.valkyrienskies.core.impl.api.ServerShipUser
import org.valkyrienskies.core.impl.api.ShipForcesInducer
import org.valkyrienskies.core.impl.api.Ticked
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl
import org.valkyrienskies.core.impl.pipelines.SegmentUtils
import org.valkyrienskies.mod.common.util.toJOML
import org.valkyrienskies.mod.common.util.toJOMLD
import org.joml.Vector3d
import java.util.concurrent.CopyOnWriteArrayList

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE
)
class SpringerController : ShipForcesInducer, ServerShipUser, Ticked {
    @JsonIgnore
    override var ship: ServerShip? = null

    private val Springers = mutableListOf<Triple<Vector3ic, Vector3dc, Double>>()

    override fun applyForces(physShip: PhysShip) {
        if (ship == null) return
        physShip as PhysShipImpl

        val mass = physShip.inertia.shipMass
        val moiTensor = physShip.inertia.momentOfInertiaTensor
        val segment = physShip.segments.segments[0]?.segmentDisplacement!!
        val omega = SegmentUtils.getOmega(physShip.poseVel, segment, Vector3d())
        val vel = SegmentUtils.getVelocity(physShip.poseVel, segment, Vector3d())

        Springers.forEach {
            val (pos, force, tier) = it

            val tForce = physShip.transform.shipToWorld.transformDirection(force, Vector3d()) //.shipToWorld.transformDirection(force, Vector3d())
            val tPos = Vector3d(pos).add(0.5, 0.5, 0.5).sub(physShip.transform.positionInShip)

            if (force.isFinite) {
                physShip.applyInvariantForceToPos(tForce.mul(2 * tier, Vector3d()), tPos)
            }
        }

    }

    override fun tick() {
    }

    fun addSpringer(pos: BlockPos, tier: Double, force: Vector3dc) {
        Springers.add(Triple(pos.toJOML(), force, tier))
    }
    fun removeSpringer(pos: BlockPos, tier: Double,force: Vector3dc) {
        Springers.remove(Triple(pos.toJOML(), force, tier))
    }

    fun forceStopSpringer(pos: BlockPos) {
        Springers.removeAll { it.first == pos }
    }



    companion object {
        fun getOrCreate(ship: ServerShip): SpringerController {
            return ship.getAttachment<SpringerController>()
                    ?: SpringerController().also { ship.saveAttachment(it) }
        }

    }
}