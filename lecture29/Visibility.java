class SuperDuper {
  int defaultInt = 1;
  public int publicInt = 10;
  private int privateInt = 100;
  void accessSomeFields() {
    this.defaultInt = 2;
    this.privateInt = 20;
    this.protectedInt = 200;
    this.publicInt = 200;
  }
  void accessSomeOtherFields(SuperDuper d) {
    d.defaultInt = 2;
    d.privateInt = 20;
    d.protectedInt = 200;
    d.publicInt = 200;
  }
}

class SubDuper extends SuperDuper {
  void accessSomeFields() {
    this.defaultInt = 2;
    this.privateInt = 20;
    this.protectedInt = 200;
    this.publicInt = 200;
  }
  void accessSomeOtherFields(SuperDuper d) {
    d.defaultInt = 2;
    d.privateInt = 20;
    d.protectedInt = 200;
    d.publicInt = 200;
  }
}

class UnrelateDuper {
  void accessSomeOtherFields(SuperDuper d) {
    d.privateInt = 20;
    d.protectedInt = 30;
    d.defaultInt = 40;
    d.publicInt = 200;
  }
}
