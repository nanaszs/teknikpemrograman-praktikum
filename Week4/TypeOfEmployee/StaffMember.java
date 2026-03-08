// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public abstract class StaffMember {
   protected String name;
   protected String address;
   protected String phone;


   public StaffMember(String var1, String var2, String var3) {
      this.name = var1;
      this.address = var2;
      this.phone = var3;
   }


   public String toString() {
      String var1 = "Name: " + this.name + "\n";
      var1 = var1 + "Address: " + this.address + "\n";
      var1 = var1 + "Phone: " + this.phone;
      return var1;
   }


   public abstract double pay();
}
