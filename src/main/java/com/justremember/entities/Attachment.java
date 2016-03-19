package com.justremember.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Andrey on 19.03.2016.
 */
@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @SequenceGenerator(name="attachment_sequence", sequenceName = "attachment_id_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachment_sequence")
    @Column
    private Long id;

    @Column(length = 250)
    private String name;

    @Column(length = 50)
    private String mime_type;

    @Column(length = 250)
    private String url;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
