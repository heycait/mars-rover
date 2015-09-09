class Plateau
  attr_accessor :grid, :cardinal_directions, :direction, :position
  def initialize(x, y)
    @grid = Array.new(y) {Array.new(x)}
    @cardinal_directions = %w(N E S W)
  end

  def update_direction
    @direction = @cardinal_directions[0]
  end

  def update_location(x = nil, y = nil)
    @position[0] = x || @position[0]
    @position[1] = y || @position[0]
  end

  def land_rover(rover_obj)
    until @cardinal_directions[0] == rover_obj.direction
      @cardinal_directions = @cardinal_directions.rotate(1)
      @direction = @cardinal_directions[0]
    end

    rover_location(rover_obj)
  end

  def rover_location(rover_obj)
    @grid[rover_obj.y][rover_obj.x] = rover_obj
    @position = [rover_obj.x, rover_obj.y]
  end

  def left
    @cardinal_directions = @cardinal_directions.rotate(-1)
    update_direction
  end

  def right
    @cardinal_directions = @cardinal_directions.rotate(1)
    update_direction
  end

  def forward
    case @direction
      when 'N'
        #move to the same location (index) in the array above(immediately preceeding)
      when 'E'
        #move one element to the right.
        # @grid[]
      when 'S'
        #move to the same location (index) in the array below (immediately following)
      when 'W'
        #move one element to the left
    end

  end


end

class Rover
  attr_accessor :location
  def initialize(args)   #x, y, direction, plateau)
    @plateau = args[:plateau]
    @location =
  end
end

mars = Plateau.new(5,5)
rover1 = Rover.new({x: 1, y: 2, direction:'N', plateau: mars})
rover2 = Rover.new({x: 3, y: 3, direction: 'E', plateau: mars})

rover1.instructions = "LMLMLMLMM"
rover2.instructions = "MMRMMRMRRM"

rover1.location
rover2.location


# write an instance method to turn L/R, meaning it changes direction based on NESW - DONE
# write an instance method to move forward one space depending on direction it's facing(which also updates the coordinates of the instance)






# write a rover class that places the rover in the proper location on the plateau

# write an instance method that accepts a string of instructions, which then calls other methods as it reads it characters

# at the end of the instructions, return final location (x,y) coordinates with direction

