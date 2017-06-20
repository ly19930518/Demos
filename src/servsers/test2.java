package servsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test2 {
	public static void main(String[] args) {
		test2 t2 = new test2();
		t2.testList();
	}
    public void testList(){

        List<User> userList = new ArrayList<>();

        userList.add(new User("zhourui","aa"));
        userList.add(new User("zhourui","aa"));
        userList.add(new User("zhourui","aa"));
        userList.add(new User("zhourui","bb"));
        userList.add(new User("zhourui","bb"));
        userList.add(new User("zhourui","bb"));
        userList.add(new User("hehehehe","bb"));

        userList.forEach(System.out::println);

        System.out.println("---------set的方式------------");
        Set<User> userSet = new HashSet<>(userList);

        userList.clear();
        userList.addAll(userSet);
        userList.forEach(System.out::println);

        System.out.println("**********集合流的方式***********");


        userList.stream().distinct().collect(Collectors.toList());
        List<User> distinct = userList.stream().distinct().collect(Collectors.toList());
        System.out.printf("原始数据list: %s,  去重后的list : %s %n", userList, distinct);


    }


    class User{

        private String name;

        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public User(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return sex != null ? sex.equals(user.sex) : user.sex == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (sex != null ? sex.hashCode() : 0);
            return result;
        }
    }

}
