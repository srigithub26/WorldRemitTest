package com.ruleengine.rest.api.model;

public class Customer {

	private int id;
	private Membership membership;
	private int loyaltyPoints;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		if ((this.membership == Membership.BOOK_CLUB && membership == Membership.VIDEO_CLUB)
				|| (this.membership == Membership.VIDEO_CLUB && membership == Membership.BOOK_CLUB)
				|| membership == Membership.PREMIUM)
			this.membership = Membership.PREMIUM;
		else
			this.membership = membership;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
}
