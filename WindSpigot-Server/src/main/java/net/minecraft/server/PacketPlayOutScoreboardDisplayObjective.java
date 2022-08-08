package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutScoreboardDisplayObjective implements Packet<PacketListenerPlayOut> {

    public int a;
    public String b;

    public PacketPlayOutScoreboardDisplayObjective() {
    }

    public PacketPlayOutScoreboardDisplayObjective(int var1, ScoreboardObjective var2) {
        this.a = var1;
        if (var2 == null) {
            this.b = "";
        } else {
            this.b = var2.getName();
        }

    }

    public void a(PacketDataSerializer var1) throws IOException {
        this.a = var1.readByte();
        this.b = var1.c(16);
    }

    public void b(PacketDataSerializer var1) throws IOException {
        var1.writeByte(this.a);
        var1.a(this.b);
    }

    public void a(PacketListenerPlayOut var1) {
        var1.a(this);
    }
}
