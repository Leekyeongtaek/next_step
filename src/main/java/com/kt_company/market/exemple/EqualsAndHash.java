package com.kt_company.market.exemple;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
@Setter
public class EqualsAndHash {

    private Integer id;

    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        EqualsAndHash e = (EqualsAndHash) o;
//        return (this.getId() == e.getId());

        return new EqualsBuilder().
            append(getId(), e.getId()).
            isEquals();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return new HashCodeBuilder(getId()%2==0?getId()+1:getId(), PRIME).toHashCode();
//        int result = 1;
//        result = PRIME * result + getId();
//        return result;
    }

    public static void main(String[] args) {

        String s1 = new String("Test");
        String s2 = new String("Test");

        // Object 객체의 equals 메서드는 객체의 참조값을 비교한다.
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        // 똥일한 객체는 동일한 메모리 주소를 갖는다는 것을 의미함. 그러므로 동일한 객체는 동일한 해시코드를 가져야 한다.
        //Java 프로그램을 실행하는 동안 equals에 사용된 정보가 수정되지 않았다면, hashCode는 항상 동일한 정수값을 반환해야 한다. (Java의 프로그램을 실행할 때 마다 달라지는 것은 상관이 없다.)
        //두 객체가 equals()에 의해 동일하다면, 두 객체의 hashCode() 값도 일치해야 한다.
        //출처: https://mangkyu.tistory.com/101?category=872426 [MangKyu's Diary:티스토리]

        EqualsAndHash equalsAndHash1 = new EqualsAndHash();
        EqualsAndHash equalsAndHash2 = new EqualsAndHash();

        equalsAndHash1.setId(100);
        equalsAndHash2.setId(100);

        //Prints 'true' now!
        System.out.println(equalsAndHash1.equals(equalsAndHash2));

        Set<EqualsAndHash> equalsAndHashes = new HashSet<>();
        equalsAndHashes.add(equalsAndHash1);
        equalsAndHashes.add(equalsAndHash2);

        System.out.println(equalsAndHashes);
    }
}
