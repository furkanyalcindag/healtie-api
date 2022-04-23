package com.comitfy.healtie.util.common;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseCrudController<DTO extends BaseDTO, Entity extends BaseEntity,
        Repository extends BaseRepository<Entity>, Mapper extends BaseMapper<DTO, Entity>,
        Service extends BaseService<DTO, Entity, Repository, Mapper>> {


    protected abstract Service getService();

    protected abstract Mapper getMapper();

    protected void validate(BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            String errors = bindingResult.getAllErrors().stream().map(n -> n.toString())
                    .collect(Collectors.joining(","));
            throw new Exception(errors);
        }
    }


    @GetMapping("/")
    public ResponseEntity<List<DTO>> getAll() {

        List<DTO> dtoList = getService().findAll();

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable Long id) {
        DTO optionalT = getService().findById(id);
        if (optionalT == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalT, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DTO> save(@RequestBody DTO body) {
        return new ResponseEntity<>(getService().save(body), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        DTO optional = getService().findById(id);

        if (optional == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Object with the id " + id + " was deleted.", HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DTO body) {
        DTO optional = getService().findById(id);

        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        } else {
            getService().update(id, body);
            return new ResponseEntity<>("Object with the id " + id + " was updated.", HttpStatus.OK);
        }

    }


}
