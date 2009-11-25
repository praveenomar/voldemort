package voldemort.store.views;

/**
 * The interface for defining a view. A separate transformation may be needed
 * for the keys and the values, and one can do just one or the other if needed.
 * 
 * This interface provides a translation from the view's type to the target
 * store's type and vice versa. If one direction is not supported, the
 * unimplemented method should throw an
 * {@link voldemort.store.views.UnsupportedViewOperationException}.
 * 
 * @author jay
 * 
 * @param <K> The type of the key
 * @param <V> The type of things in the view
 * @param <S> The type of things in the store
 */
public interface ViewTransformation<K, V, S> {

    /**
     * Translate from the store type to the view type
     * 
     * @param s The value for the store
     * @return The value for the view
     * @throws UnsupportedViewOperationException If this direction of translation is not
     *         allowed
     */
    public V fromStoreToView(K k, S s) throws UnsupportedViewOperationException;

    /**
     * Translate from the view type to the store type
     * 
     * @param v The view type
     * @return The store type
     * @throws UnsupportedViewOperationException If this direction of translation is not
     *         allowed
     */
    public S fromViewToStore(K k, V v) throws UnsupportedViewOperationException;

}