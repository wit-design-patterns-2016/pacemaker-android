package org.pacemaker.models;

import static com.google.common.base.Objects.toStringHelper;
import com.google.common.base.Objects;

public class MyActivity
{
  public Long   id;
  public String type;
  public String location;
  public double distance;

  public MyActivity()
  {
  }

  public MyActivity(String type, String location, double distance)
  {
    this.type      = type;
    this.location  = location;
    this.distance  = distance;
  }

  @Override
  public String toString()
  {
    return toStringHelper(this).addValue(id)
        .addValue(type)
        .addValue(location)
        .addValue(distance)
        .toString();
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof MyActivity)
    {
      final MyActivity other = (MyActivity) obj;
      return Objects.equal(type, other.type)
          && Objects.equal(location,  other.location)
          && Objects.equal(distance,  other.distance);
    }
    else
    {
      return false;
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hashCode(this.id, this.type, this.location, this.distance);
  }
}