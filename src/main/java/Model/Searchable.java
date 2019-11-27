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
public interface Searchable {

    /**
     * @return the found
     */
    boolean getFound();

    /**
     * @return the foundIndex
     */
    int getFoundIndex();

    /**
     * @return the searchByField
     */
    int getSearchByField();

    boolean search(String searchTerm);

    /**
     * @param found the found to set
     */
    void setFound(boolean found);

    /**
     * @param foundIndex the foundIndex to set
     */
    void setFoundIndex(int foundIndex);

    /**
     * @param searchByField the searchByField to set
     */
    void setSearchByField(int searchByField);
    
}
