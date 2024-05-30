package com.exchratenbp.domain.currency;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

class InMemoryCurrencyRepository implements CurrencyRepository {

    Map<Long, CurrencyRequest> inMemoryDb = new ConcurrentHashMap<>();

    @Override
    public CurrencyRequest save(CurrencyRequest currencyRequest) {

        final long id = inMemoryDb.size() + 1L;

        currencyRequest.setId(id);
        inMemoryDb.put(id, currencyRequest);

        return currencyRequest;
    }

    @Override
    public List<CurrencyRequest> findAll() {
        return inMemoryDb.values()
                .stream()
                .toList();
    }

    public void addCurrencyRequest(CurrencyRequest currencyRequest) {
        inMemoryDb.put(currencyRequest.getId(), currencyRequest);
    }


    /* THE REST OF THE UNUSED JpaRepository METHODS BELOW */

    @Override
    public <S extends CurrencyRequest> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CurrencyRequest> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<CurrencyRequest> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CurrencyRequest entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CurrencyRequest> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CurrencyRequest> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CurrencyRequest> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CurrencyRequest> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CurrencyRequest getOne(Long aLong) {
        return null;
    }

    @Override
    public CurrencyRequest getById(Long aLong) {
        return null;
    }

    @Override
    public CurrencyRequest getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CurrencyRequest> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CurrencyRequest> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CurrencyRequest> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CurrencyRequest> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CurrencyRequest> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CurrencyRequest> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CurrencyRequest, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<CurrencyRequest> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CurrencyRequest> findAll(Pageable pageable) {
        return null;
    }
}
