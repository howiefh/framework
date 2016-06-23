package io.github.howiefh.mybatis;

/**
 * @author fenghao on 2016/5/16
 * @version 1.0
 * @since 1.0
 */
public class Page implements Pageable{
    private int pageNumber;
    private int pageSize;
    private long total;

    public Page(int pageNumber, int pageSize, long total) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Returns the number of items to be returned.
     *
     * @return the number of items of that page
     */
    @Override
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken
     */
    @Override
    public int getOffset() {
        return pageNumber*pageSize;
    }

    public int getTotalPages() {
        return getPageSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getPageSize());
    }

    public long getTotalElements() {
        return total;
    }

    /**
     * Returns the {@link Pageable} requesting the next {@link Page}.
     *
     * @return
     */
    @Override
    public Pageable next() {
        return new Page(getPageNumber() + 1, getPageSize(), getTotalElements());
    }

    /**
     * Returns the previous {@link Pageable} or the first {@link Pageable} if the current one already is the first one.
     *
     * @return
     */
    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public Pageable previous() {
        return getPageNumber() == 0 ? this : new Page(getPageNumber() - 1, getPageSize(), getTotalElements());
    }
    /**
     * Returns the {@link Pageable} requesting the first page.
     *
     * @return
     */
    @Override
    public Pageable first() {
        return new Page(0, getPageSize(), getTotalElements());
    }

    /**
     * Returns whether there's a previous {@link Pageable} we can access from the current one. Will return
     * {@literal false} in case the current {@link Pageable} already refers to the first page.
     *
     * @return
     */
    @Override
    public boolean hasPrevious() {
        return pageNumber > 0;
    }

    public boolean hasNext() {
        return getPageNumber() + 1 < getTotalPages();
    }

    public boolean isLast() {
        return !hasNext();
    }
}
