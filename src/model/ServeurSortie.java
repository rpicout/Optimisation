package model;

import java.util.Comparator;

public class ServeurSortie {
	
	private int id;
	private int row;
	private int slot;
	private int groupe;
	
	public ServeurSortie(int id, int row, int slot, int groupe) {
		this.id = id;
		this.row = row;
		this.slot = slot;
		this.groupe = groupe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
	public static final Comparator<ServeurSortie> ID_COMPARATOR = new Comparator<ServeurSortie>() {

		@Override
		public int compare(ServeurSortie arg0, ServeurSortie arg1) {
			// TODO Auto-generated method stub
			ServeurSortie p = (ServeurSortie) arg0;
			ServeurSortie q = (ServeurSortie) arg1;
			if (p.id > q.id)
				return 1;
			else
				return -1;
		}

	};

}
