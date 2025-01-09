package reflect;

public class TestUser {
        private String name = "init";
        private int age;
        public TestUser() {}
        public TestUser(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }
        private String getName() {
            return name;
        }
        private void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "TestUser [name=" + name + ", age=" + age + "]";
        }
    }
