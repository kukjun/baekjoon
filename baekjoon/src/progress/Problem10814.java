package progress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나이순 정렬
public class Problem10814 {
    static class Person {
        int age;
        String name;
        int count;

        public Person(int age, String name, int count) {
            this.age = age;
            this.name = name;
            this.count = count;
        }


        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.stream(people)
                .sorted((o1, o2) -> {
                    if (o1.age > o2.age) return 1;
                    else if (o1.age == o2.age) return (o1.count > o2.count) ? 1 : -1;
                    else return -1;
                })
                .forEach(System.out::println);

    }
}
