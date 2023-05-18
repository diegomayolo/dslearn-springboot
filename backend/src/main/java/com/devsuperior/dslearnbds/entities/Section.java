package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.enums.ResourceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_section")
public class Section implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;

    @ManyToOne
    @JoinColumn( name = "resource_id" )
    private Resource resource;

    @ManyToOne
    @JoinColumn( name = "prerequisite_id" )
    private Section prerequiste;

    public Section()
    {
    }

    public Section( Long id, String title, String description, Integer position, String imgUri, Resource resource, Section prerequiste )
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
        this.resource = resource;
        this.prerequiste = prerequiste;
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Integer getPosition()
    {
        return position;
    }

    public void setPosition( Integer position )
    {
        this.position = position;
    }

    public String getImgUri()
    {
        return imgUri;
    }

    public void setImgUri( String imgUri )
    {
        this.imgUri = imgUri;
    }

    public Resource getResource()
    {
        return resource;
    }

    public void setResource( Resource resource )
    {
        this.resource = resource;
    }

    public Section getPrerequiste()
    {
        return prerequiste;
    }

    public void setPrerequiste( Section prerequiste )
    {
        this.prerequiste = prerequiste;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( !( o instanceof Section ) ) return false;
        Section section = ( Section ) o;
        return Objects.equals( getId(), section.getId() );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( getId() );
    }
}
