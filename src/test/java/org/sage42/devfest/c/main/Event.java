package org.sage42.devfest.c.main;

import com.google.gson.annotations.SerializedName;

public class Event
{
    private String text;

    private String title;

    private String image;

    private String link;

    @SerializedName("resource_uri")
    private String resourceUri;

    public Event()
    {
        super();
    }

    public String getText()
    {
        return this.text;
    }

    public void setText(final String text)
    {
        this.text = text;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(final String image)
    {
        this.image = image;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setLink(final String link)
    {
        this.link = link;
    }

    public String getResourceUri()
    {
        return this.resourceUri;
    }

    public void setResourceUri(final String resourceUri)
    {
        this.resourceUri = resourceUri;
    }

    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Event [");
        if (this.text != null)
        {
            builder.append("text=");
            builder.append(this.text);
            builder.append(", ");
        }
        if (this.title != null)
        {
            builder.append("title=");
            builder.append(this.title);
            builder.append(", ");
        }
        if (this.image != null)
        {
            builder.append("image=");
            builder.append(this.image);
            builder.append(", ");
        }
        if (this.link != null)
        {
            builder.append("link=");
            builder.append(this.link);
            builder.append(", ");
        }
        if (this.resourceUri != null)
        {
            builder.append("resourceUri=");
            builder.append(this.resourceUri);
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.image == null) ? 0 : this.image.hashCode());
        result = (prime * result) + ((this.link == null) ? 0 : this.link.hashCode());
        result = (prime * result) + ((this.resourceUri == null) ? 0 : this.resourceUri.hashCode());
        result = (prime * result) + ((this.text == null) ? 0 : this.text.hashCode());
        result = (prime * result) + ((this.title == null) ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final Event other = (Event) obj;
        if (this.image == null)
        {
            if (other.image != null)
            {
                return false;
            }
        }
        else if (!this.image.equals(other.image))
        {
            return false;
        }
        if (this.link == null)
        {
            if (other.link != null)
            {
                return false;
            }
        }
        else if (!this.link.equals(other.link))
        {
            return false;
        }
        if (this.resourceUri == null)
        {
            if (other.resourceUri != null)
            {
                return false;
            }
        }
        else if (!this.resourceUri.equals(other.resourceUri))
        {
            return false;
        }
        if (this.text == null)
        {
            if (other.text != null)
            {
                return false;
            }
        }
        else if (!this.text.equals(other.text))
        {
            return false;
        }
        if (this.title == null)
        {
            if (other.title != null)
            {
                return false;
            }
        }
        else if (!this.title.equals(other.title))
        {
            return false;
        }
        return true;
    }

}
