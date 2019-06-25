/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lbc5186
 */
public interface Sortable {
  public int getSortField();
  public void sort(int sortField, int sortType); 
  public void setSortField(int sortField);
}
