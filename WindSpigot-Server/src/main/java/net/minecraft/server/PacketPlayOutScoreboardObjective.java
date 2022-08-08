package net.minecraft.server;

import java.io.IOException;

import net.minecraft.server.IScoreboardCriteria.EnumScoreboardHealthDisplay;

public class PacketPlayOutScoreboardObjective implements Packet<PacketListenerPlayOut> {

    public String a;
    public String b;
    public IScoreboardCriteria.EnumScoreboardHealthDisplay c;
    public int d;

    public PacketPlayOutScoreboardObjective() {
    }

    public PacketPlayOutScoreboardObjective(ScoreboardObjective var1, int var2) {
        this.a = var1.getName();
        this.b = var1.getDisplayName();
        this.c = var1.getCriteria().c();
        this.d = var2;
    }

    public void a(PacketDataSerializer var1) throws IOException {
        this.a = var1.c(16);
        this.d = var1.readByte();
        if (this.d == 0 || this.d == 2) {
            this.b = var1.c(32);
            this.c = EnumScoreboardHealthDisplay.a(var1.c(16));
        }

    }

    public void b(PacketDataSerializer var1) throws IOException {
        var1.a(this.a);
        var1.writeByte(this.d);
        if (this.d == 0 || this.d == 2) {
            var1.a(this.b);
            var1.a(this.c.a());
        }

    }

    public void a(PacketListenerPlayOut var1) {
        var1.a(this);
    }
}
