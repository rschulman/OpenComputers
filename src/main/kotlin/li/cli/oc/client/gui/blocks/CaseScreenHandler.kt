package li.cli.oc.client.gui.blocks

import li.cli.oc.Components
import li.cli.oc.client.gui.blocks.slots.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot

class CaseScreenHandler : ScreenHandler {
    private val inventory = SimpleInventory(10)
    var tier: Int? = null

    constructor(syncId: Int, playerInventory: PlayerInventory, buf: PacketByteBuf) : this(syncId, playerInventory, buf.readInt()) {
    }

    constructor(syncId: Int, playerInventory: PlayerInventory, _tier: Int?) : super(Components.CASE_SCREEN_HANDLER, syncId) {
        if (_tier != null) {
            this.tier = _tier
        }
        addSlot(Slot(inventory, 0, 43, 35)) // EEPROM Slot
        if (this.tier == 1) {
            // Two Expansion Slot Cards to the left of the component grid
            addSlot(Slot(inventory, 1, 97, 16))
            addSlot(Slot(inventory, 2, 97, 34))

            // One CPU Slot in the center top of the component grid
            addSlot(Slot(inventory, 3, 120, 16))

            // Two RAM Slots in the direct middle and bottom middle of the component grid
            addSlot(Slot(inventory, 4, 120, 34))
            addSlot(Slot(inventory, 5, 120, 52))

            // One HDD Slot in the top right of the component grid
            addSlot(Slot(inventory, 6, 143, 16))
        }
        if (this.tier == 2) {
            // Two Expansion Slot Cards to the left of the component grid
            addSlot(Slot(inventory, 1, 97, 16))
            addSlot(Slot(inventory, 2, 97, 34))

            // One CPU Slot in the center top of the component grid
            addSlot(Slot(inventory, 3, 120, 16))

            // Two RAM Slots in the direct middle and bottom middle of the component grid
            addSlot(Slot(inventory, 4, 120, 34))
            addSlot(Slot(inventory, 5, 120, 52))

            // Two HDD Slots in the top right and middle right of the component grid
            addSlot(Slot(inventory, 6, 143, 16))
            addSlot(Slot(inventory, 7, 143, 34))
        }
    }

    override fun canUse(player: PlayerEntity?): Boolean {
        return inventory.canPlayerUse(player)
    }
}
