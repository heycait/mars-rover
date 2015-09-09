# need Terrain class to monitor what's on it and where
# then need to modify forward method to ensure nothing is there before moving
# how can I do this not using a nested array grid system??

class Terrain
  attr_accessor :x, :y
  def initialize(x, y)
    @x = x
    @y = y
  end
end

class Rover
  attr_accessor :position, :direction, :cardinal_directions, :terrain, :instructions
  def initialize(args)
    @position = {x: args[:x], y: args[:y]}
    @direction = args[:direction]
    set_cardinal
    @terrain = args[:terrain]
  end

  def set_cardinal
    @cardinal_directions = %w(N E S W)
    until @cardinal_directions[0] == @direction
      @cardinal_directions = @cardinal_directions.rotate(1)
    end
  end

  def update_direction
    @direction = @cardinal_directions[0]
  end

  def left
    @cardinal_directions = @cardinal_directions.rotate(-1)
    update_direction
  end

  def right
    @cardinal_directions = @cardinal_directions.rotate(1)
    update_direction
  end

  def instructions(string)
    @instructions = string
    i = 0
    while i < @instructions.length
      case @instructions[i]
        when 'L'
          left
        when 'R'
          right
        when 'M'
          forward
      end
      i+=1
    end
  end

  def forward
    case @direction
      when 'N'
        @position[:y] += 1 if @position[:y] < @terrain.y
      when 'E'
        @position[:x] += 1 if @position[:x] < @terrain.x
      when 'S'
        @position[:y] -= 1 if @position[:y] > 0
      when 'W'
        @position[:x] -= 1 if @position[:x] > 0
    end
  end

end

# Driver Tests
mars = Terrain.new(5,5)

rover1 =  Rover.new({x: 1, y: 2, direction:'N', terrain: mars})
rover1.instructions("LMLMLMLMM")
p rover1.direction #=> N
p rover1.position #=> {x: 1, y: 3}

rover2 = Rover.new({x: 3, y: 3, direction: 'E', terrain: mars})
rover2.instructions("MMRMMRMRRMM")
p rover2.direction #=> E
p rover2.position #=> {x: 5, y: 1}