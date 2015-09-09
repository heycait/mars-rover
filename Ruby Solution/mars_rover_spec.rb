require_relative "mars_rover"

describe "the Rover class" do
  it "initializes with a position (x, y)" do
    Rover.new() == "Hello!"
  end

  it "initializes with a direction (N, E, S, or W)" do
    hello.should == "Hello!"
  end

  it "initializes with cardinal directions starting with the current direction" do
    hello.should == "Hello!"
  end
end

# describe "the greet function" do
#   it "says hello to someone" do
#     greet("Alice").should == "Hello, Alice!"
#   end

#   it "says hello to someone else" do
#     greet("Bob").should == "Hello, Bob!"
#   end
# end