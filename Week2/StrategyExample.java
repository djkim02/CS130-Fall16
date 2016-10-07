/**
 * @author		DJ Kim <djkim@cs.ucla.edu>
 *
 * CS 130 Fall 2016
 *
 * Created to illustrate a "real-life" example of Strategy Design Pattern
 * Mario has different way of jumping or attacking depending on the item
 * that he consumes. For example, Mario can jump and only attack by
 * jumping on enemies. Super Mario can spin jump but still only attack by
 * jumping on enemies. Flower Mario can spin jump and spit out fire to
 * attack. Cape Mario can fly and use his cape to attack.
 *
 */

// context
public class Mario {
	private JumpStrategy jumpStrategy;
	private AttackStrategy attackStrategy;

	public Mario() {
		jumpStrategy = new Jump();
		attackStrategy = new JumpAttack();
	}

	public void performJump() {
		jumpStrategy.attack();
	}

	public void performAttack() {
		attackStrategy.attack();
	}

	public void setJumpStrategy(JumpStrategy jumpStrategy) {
		this.jumpStrategy = jumpStrategy;
	}

	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}
}

// Strategy
public interface AttackStrategy {
	public void attack();
}

public interface JumpStrategy {
	public void jump();
}

// Concrete Strategy
public class JumpAttack implements AttackStrategy {
	public void attack() {
		System.out.println("Jump attack!");
	}
}

public class FireAttack implements AttackStrategy {
	public void attack() {
		System.out.println("Fire attack!");
	}
}

public class CapeAttack implements AttackStrategy {
	public void attack() {
		System.out.println("Cape attack!");
	}
}

public class Jump implements JumpStrategy {
	public void jump() {
		System.out.println("Jump!");
	}
}

public class SpinJump implements JumpStrategy {
	public void jump() {
		System.out.println("Spin jump!");
	}
}

public class FlyJump implements JumpStrategy {
	public void jump() {
		System.out.println("Fly jump!");
	}
}
