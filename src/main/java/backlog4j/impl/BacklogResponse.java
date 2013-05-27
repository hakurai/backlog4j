package backlog4j.impl;

import backlog4j.Named;
import backlog4j.identified;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author eguchi
 */
public abstract class BacklogResponse<T> implements List<T> {

    public abstract List<T> getDelegate();

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean contains(Object o) {
        return getDelegate().contains(o);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return getDelegate().containsAll(c);
    }
    @Override
    public boolean equals(Object o) {
        return getDelegate().equals(o);
    }
    @Override
    public T get(int index) {
        return getDelegate().get(index);
    }
    @Override
    public int hashCode() {
        return getDelegate().hashCode();
    }
    @Override
    public int indexOf(Object o) {
        return getDelegate().indexOf(o);
    }
    @Override
    public boolean isEmpty() {
        return getDelegate().isEmpty();
    }
    @Override
    public Iterator<T> iterator() {
        return getDelegate().iterator();
    }
    @Override
    public int lastIndexOf(Object o) {
        return getDelegate().lastIndexOf(o);
    }
    @Override
    public ListIterator<T> listIterator() {
        return getDelegate().listIterator();
    }
    @Override
    public ListIterator<T> listIterator(int index) {
        return getDelegate().listIterator(index);
    }
    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int size() {
        return getDelegate().size();
    }
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return getDelegate().subList(fromIndex, toIndex);
    }
    @Override
    public Object[] toArray() {
        return getDelegate().toArray();
    }
    @Override
    public <T1 extends Object> T1[] toArray(T1[] a) {
        return getDelegate().toArray(a);
    }

    protected <T1 extends identified> T1 getById(List<T1> list, Integer id) {
        for (T1 t1 : list) {
            if (t1.getId().equals(id)) {
                return t1;
            }
        }
        return null;
    }

    protected <T1 extends Named> T1 getByName(List<T1> list, String name) {
        for (T1 t1 : list) {
            if (t1.getName().equals(name)) {
                return t1;
            }
        }
        return null;
    }
}
