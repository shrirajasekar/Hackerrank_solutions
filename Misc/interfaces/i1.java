package interfaces;

interface i1 {
  void draw();
}

abstract class A {
  void dol() {
    System.out.println("A");
  }
}

class B extends A {
  void dol() {

  }
}

class C extends B {
  void dol() {

  }

}
